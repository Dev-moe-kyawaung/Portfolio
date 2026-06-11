require('dotenv').config();
const express = require('express');
const nodemailer = require('nodemailer');
const crypto = require('crypto');

const app = express();
app.use(express.json());

const PORT = process.env.PORT || 3000;

// Mailtrap transporter
const transporter = nodemailer.createTransport({
  host: 'smtp.mailtrap.io',
  port: 2525,
  auth: {
    user: process.env.MAILTRAP_USERNAME,
    pass: process.env.MAILTRAP_PASSWORD
  }
});

// Mock database
const verifications = new Map();

app.post('/api/send-verification', async (req, res) => {
  const { name, email, phone, subject, message } = req.body;
  
  const token = crypto.randomBytes(32).toString('hex');
  const expiresAt = new Date(Date.now() + 24 * 60 * 60 * 1000);
  
  verifications.set(token, {
    email,
    token,
    expiresAt,
    contactData: { name, phone, subject, message },
    emailVerified: false
  });
  
  const verificationUrl = `http://localhost:5500/verify-email.html?token=${token}`;
  
  console.log('📧 VERIFICATION:', verificationUrl);
  console.log('Token:', token);
  
  try {
    await transporter.sendMail({
      from: '"Portfolio" <test@domain.com>',
      to: email,
      subject: 'Verify Email',
      html: `<a href="${verificationUrl}">Verify Email</a>`
    });
    
    res.json({ success: true });
  } catch (error) {
    res.status(500).json({ error: 'Failed' });
  }
});

app.get('/api/verify-email', async (req, res) => {
  const { token } = req.query;
  const verification = verifications.get(token);
  
  if (!verification) {
    return res.status(400).json({ error: 'Invalid token' });
  }
  
  if (verification.expiresAt < new Date()) {
    return res.status(400).json({ error: 'Expired' });
  }
  
  verification.emailVerified = true;
  res.json({ message: 'Verified' });
});

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
