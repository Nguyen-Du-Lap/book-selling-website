// ----------handle huyện tỉnh xã----------
var citis = document.getElementById("city");
var districts = document.getElementById("district");
var wards = document.getElementById("ward");
var Parameter = {
  url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json", 
  method: "GET", 
  responseType: "application/json", 
};
var promise = axios(Parameter);
promise.then(function (result) {
  renderCity(result.data);
});


function renderCity(data) {
  for (const x of data) {
    citis.options[citis.options.length] = new Option(x.Name, x.Name);
  }
  citis.onchange = function () {
    district.length = 1;
    ward.length = 1;

    if(this.value != ""){
      const result = data.filter(n => n.Name === this.value);

      for (const k of result[0].Districts) {
        district.options[district.options.length] = new Option(k.Name, k.Name);

      }
    }
  };
  district.onchange = function () {
    ward.length = 1;
    const dataCity = data.filter((n) => n.Name === citis.value);
    if (this.value != "") {
      const dataWards = dataCity[0].Districts.filter(n => n.Name === this.value)[0].Wards;

      for (const w of dataWards) {
        wards.options[wards.options.length] = new Option(w.Name, w.Name);

      }


    }

  };
  wards.onchange =function () {
    deliveryFee(district.value,wards.value)
    deliveryFeeTotal(district.value,wards.value)
  }


    function deliveryFee(obj, abj) {
    const giaTri = obj+"/"+abj;
    $.ajax({
    url: "/orderFee",
    type: "get",
    data: {
    exits: giaTri
  },
    success: function (data) {
      const parts = data.split(",");
      const part1 = parts[0].trim();
      const part2 = parseFloat(parts[1].trim());
      const  part3=part1.replace(/\[/g, '');
    const row = document.getElementById("sum_transport");
      const time = document.getElementById("date_transport");
    row.innerText = part2+ 'đ';
    time.innerText= part3;

  }
  })
  }
  function deliveryFeeTotal(obj, abj) {
    const giaTri = obj+"/"+abj;
    $.ajax({
      url: "/orderFee",
      type: "post",
      data: {
        exits: giaTri
      },
      success: function (data) {
        const part12 = data.replace(/\r?\n|\r/g, '');
        const row1 = document.getElementById("sum_order");
        row1.innerText = part12;

      }
    })
  }

}

// ---------------handle form -----------
const form_submit = document.getElementById('submit_form')
const fname = document.getElementById('name')
const nameValue2 = fname.value.trim()
const phone = document.getElementById('phone')
const email = document.getElementById('email')
const address = document.getElementById('address')
const city = document.getElementById('city')
const district = document.getElementById('district')
const ward = document.getElementById('ward')
const pack = document.getElementById('pack')
const pay = document.getElementById('pay')


// Xử lý submit form

$('#bnt_submit').click(function () {
  if(checkInputs() > 0) {

  }else {
    $('#submit_form').submit();
  }
})

// Xử lý onchane input
function nameOnChange(value) {
  if(value === '') {
    setError(fname, 'Vui lòng nhập tên của bạn');
  } else {
      setSuccess(fname);
  }
}

function phoneOnChange(value) {
  if(value === '') {
    setError(phone, 'Vui lòng nhập số điện thoại của bạn');
  } else if(!isPhoneNumber(value)) {
      setError(phone, 'Số điện thoại không hợp lệ')
  } else {
      setSuccess(phone);
  }
}

function emailOnChange(value) {
  if(value === '') {
    setError(email, 'Vui lòng nhập vào email');
  } else if(!isEmail(value)) {
      setError(email, 'Email không hợp lệ');
  } else {
      setSuccess(email);
  }
}

function addressOnChange(value) {
  if(value === '') {
    setError(address, 'Vui lòng nhập địa chỉ của bạn');
  } else {
      setSuccess(address);
  }
}


function checkInputs() {
  let count = 0;
  const nameValue = fname.value.trim()
  const phoneValue = phone.value.trim()
  const emailValue = email.value.trim()
  const addressValue = address.value.trim()
  const cityValue = city.options[city.selectedIndex].text
  const districtValue = district.options[district.selectedIndex].text
  const wardValue = ward.options[ward.selectedIndex].text
  const packValue = pack.options[pack.selectedIndex].text
  const payValue = pay.options[pay.selectedIndex].text

  //check name
  if(nameValue === '') {
    count++;
    setError(fname, 'Vui lòng nhập tên của bạn');
  } else {
      setSuccess(fname);
  }

//check phone
  if(phoneValue === '') {
    count++;
    setError(phone, 'Vui lòng nhập số điện thoại của bạn');
  } else if(!isPhoneNumber(phoneValue)) {
    count++;
    setError(phone, 'Số điện thoại không hợp lệ')
  } else {
      setSuccess(phone);
  }

  //check email
  if(emailValue === '') {
    count++;
    setError(email, 'Vui lòng nhập vào email');
  } else if(!isEmail(emailValue)) {
    count++;
      setError(email, 'Email không hợp lệ');
  } else {
      setSuccess(email);
  }

    //check address
    if(addressValue === '') {
      count++;
      setError(address, 'Vui lòng nhập địa chỉ của bạn');
    } else {
        setSuccess(address);
    }

  //check city
  if(cityValue === 'Chọn tỉnh thành') {
    count++;
    setError(city, 'Vui lòng chọn tỉnh thành phố');
  } else {
    setSuccess(city);
  }

  //check district
  if(districtValue === 'Chọn quận huyện') {
    count++;
    setError(district, 'Vui lòng chọn tỉnh quận huyện');
  } else {
    setSuccess(district);
  }

  //check ward
  if(wardValue === 'Chọn phường xã') {
    count++;
    setError(ward, 'Vui lòng chọn phường xã');
  } else {
    setSuccess(ward);
  }

  //check pack
  if(packValue === 'Chọn quy cách đóng gói') {
    count++;
    setError(pack, 'Vui lòng chọn quy cách đóng gói');
  } else {
    setSuccess(pack);
  }

  //check pay
  if(payValue === 'Chọn hình thức') {
    count++;
    setError(pay, 'Vui lòng chọn hình thức thanh toán');
  } else {
    setSuccess(pay);
  }
  return count;
}

//set error and success all

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

//check phone
function isPhoneNumber(phoneNumber) {
  return /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(phoneNumber);
}


//check email
function isEmail(email) {
  return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}



