const form_forgotPassword = document.getElementById('form_forgotPassword');
const email = document.getElementById('email');

//form_forgotPassword.addEventListener('submit', (e) => {
//    e.preventDefault();
//    checkInputs();
//});

function checkInputs() {
    const emailValue = email.value.trim();

    if (emailValue === '') {
        setErrorFor(email, 'Vui lòng nhập vào email');
    } else if (!isEmail(emailValue)) {
        setErrorFor(email, 'Email không hợp lệ');
    } else {
        setSuccessFor(email);
    }

    function setErrorFor(input, message) {
        const formControl = input.parentElement;
        const small = formControl.querySelector('small');
        small.innerText = message;
        formControl.className = 'input error';
    }

    function setSuccessFor(input) {
        const formControl = input.parentElement;
        formControl.className = 'input success';
    }

    function isEmail(email) {
        return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
    }
}