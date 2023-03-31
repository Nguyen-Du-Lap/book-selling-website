const form_signUp = document.getElementById('form_signUp');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');
const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const phoneNumber = document.getElementById('phoneNumber');

// Xử lý submit form
$('#btn-signUp').click(function () {
    if(checkInputs() > 0) {
        $('#form_signUp').preventDefault();
    }else {
        $('#form_signUp').submit();
    }
})

//handle onchane
function emailOnChange(value) {
    if(value === '') {
      setError(email, 'Vui lòng nhập vào email');
    } else if(!isEmail(value)) {
        setError(email, 'Email không hợp lệ');
    } else {
        setSuccess(email);
    }
}

var passwordOnchane = ""

function passwordOnChange(value) {
    passwordOnchane = value
    if(value === '') {
        setError(password, 'Vui lòng nhập vào mật khẩu');
    } else if(value.length < 8) {
        setError(password, 'Mật khẩu phải có ít nhất 8 kí tự');
    } else if(!checkPassword(value)) {
        setErrorFor(password, 'Mật khẩu phải có kí tự in hoa, số và 1 kí tự đặt biệt');
    }
    else {
        setSuccess(password);   
    }
}

function passwordAOnChange(value) {
    if(value === '') {
        setError(password2, 'Vui lòng nhập lại mật khẩu');
    }
    if(value.length < 8) {
        setError(password2, 'Mật khẩu phải có ít nhất 8 kí tự');
    }
    else if (value !== passwordOnchane) {
        setError(password2, "Mật khẩu không khớp");
    } else {
        setSuccess(password2);
    }
}

function namefOnChange(value) {
    if(value === '') {
        setErrorForFName(fname, 'Vui lòng nhập họ của bạn');
    } else {
        setSuccessForFName(fname);
    }
}

function namelOnChange(value) {
    if(value === '') {
        setErrorForLName(lname, 'Vui lòng nhập tên của bạn');
    } else {
        setSuccessForLName(lname);
    }
}

function phoneOnChange(value) {
    if(value === '') {
      setError(phoneNumber, 'Vui lòng nhập số điện thoại của bạn');
    } else if(!isPhoneNumber(value)) {
        setError(phoneNumber, 'Số điện thoại không hợp lệ')
    } else {
        setSuccess(phoneNumber);
    }
}

function setError(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input error';
}
function setSuccess(input) {
    const formControl = input.parentElement;
    formControl.className = 'input success';
}

function setErrorForFName(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input fname error';
}
function setSuccessForFName(input) {
    const formControl = input.parentElement;
    formControl.className = 'input fname success';
}
function setErrorForLName(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input lname error';
}
function setSuccessForLName(input) {
    const formControl = input.parentElement;
    formControl.className = 'input lname success';
}


//handle when submit
function checkInputs() {
    let count = 0
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const password2Value = password2.value.trim();
    const fnameValue = fname.value.trim();
    const lnameValue = lname.value.trim();
    const phoneNumberValue = phoneNumber.value.trim();

    if(emailValue === '') {
        count++;
        setErrorFor(email, 'Vui lòng nhập vào email');
    } else if(!isEmail(emailValue)) {
        count++;
        setErrorFor(email, 'Email không hợp lệ');
    } else {
        setSuccessFor(email);
    }


    if(passwordValue === '') {
        count++;
        setErrorFor(password, 'Vui lòng nhập vào mật khẩu');
    } else if(passwordValue.length < 8) {
        count++;
        setErrorFor(password, 'Mật khẩu phải có ít nhất 8 kí tự');
    } else if(!checkPassword(passwordValue)) {
        count++;
        setErrorFor(password, 'Mật khẩu phải có kí tự in hoa, số và 1 kí tự đặt biệt');
    } else {
        setSuccessFor(password);
    }



    if(password2Value === '') {
        count++;
        setErrorFor(password2, 'Vui lòng nhập lại mật khẩu');
    } else if (password2Value !== passwordValue) {
        count++;
        setErrorFor(password2, "Mật khẩu không khớp");
    } else {
        setSuccessFor(password2);
    }

    if(fnameValue === '') {
        count++;
        setErrorForFName(fname, 'Vui lòng nhập họ của bạn');
    } else {
        setSuccessForFName(fname);
    }

    if(lnameValue === '') {
        count++;
        setErrorForLName(lname, 'Vui lòng nhập tên của bạn');
    } else {
        setSuccessForLName(lname);
    }

    if(!isPhoneNumber(phoneNumberValue)) {
        count++;
        setErrorFor(phoneNumber, 'Số điện thoại không hợp lệ');
    } else {
        setSuccessFor(phoneNumber);
    }
    return count
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
function setErrorForFName(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input fname error';
}
function setSuccessForFName(input) {
    const formControl = input.parentElement;
    formControl.className = 'input fname success';
}
function setErrorForLName(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
    formControl.className = 'input lname error';
}
function setSuccessForLName(input) {
    const formControl = input.parentElement;
    formControl.className = 'input lname success';
}
function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}
function isPhoneNumber(phoneNumber) {
    return /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phoneNumber);
}

function checkPassword(password) {
    return /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?])/.test(password)
}


