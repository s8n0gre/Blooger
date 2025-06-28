// login.js
document.addEventListener("DOMContentLoaded", function () {
    const togglePassword = document.getElementById('togglePassword');
    const passwordField = document.getElementById('Pass');
    const usernameField = document.getElementById('username');

    if (togglePassword) {
        togglePassword.addEventListener('click', function () {
            const isHidden = passwordField.getAttribute('type') === 'password';
            passwordField.setAttribute('type', isHidden ? 'text' : 'password');
            this.textContent = isHidden ? '◕⩊◕' : '>⩊<';

            usernameField.classList.remove('glow');
            passwordField.classList.remove('glow');

            if (isHidden) {
                passwordField.classList.add('glow');
            } else {
                usernameField.classList.add('glow');
            }
        });
    }
});
