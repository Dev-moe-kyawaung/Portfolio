// Mobile Menu Toggle
const navToggle = document.getElementById('navToggle');
const navMenu = document.getElementById('navMenu');

navToggle.addEventListener('click', () => {
  navMenu.style.display = navMenu.style.display === 'flex' ? 'none' : 'flex';
});

// Typing Effect
const roles = [
  'Android Developer',
  'Kotlin Engineer',
  'Jetpack Compose Specialist',
  'Flutter Developer',
];

let currentIndex = 0;
let currentText = '';
let isDeleting = false;
const typingText = document.getElementById('typingText');

function typeEffect() {
  const currentRole = roles[currentIndex];
  
  if (!isDeleting) {
    if (currentText.length < currentRole.length) {
      currentText = currentRole.substring(0, currentText.length + 1);
    } else {
      isDeleting = true;
    }
  } else {
    if (currentText.length > 0) {
      currentText = currentRole.substring(0, currentText.length - 1);
    } else {
      isDeleting = false;
      currentIndex = (currentIndex + 1) % roles.length;
    }
  }
  
  typingText.textContent = currentText + '▍';
  
  setTimeout(typeEffect, isDeleting ? 45 : 70);
}

typeEffect();

// Active Nav Link
const navLinks = document.querySelectorAll('.nav-link');
const currentPage = window.location.pathname;

navLinks.forEach(link => {
  if (link.getAttribute('href') === currentPage) {
    link.classList.add('active');
  }
});
