function validTextInputs() {
   let textInputs = [
      document.forms.register.firstName,
      document.forms.register.lastName,
      document.forms.register.address,
      document.forms.register.userID,
      document.forms.register.email,
      document.forms.register.password,
      document.forms.register.confirmPassword
   ]

   inputsLength = textInputs.length;

   for (let i = 0; i < inputsLength; i++) {
      if (textInputs[i].value == "") {
         textInputs[i].focus();
         return false;
      }
   }

   return true;
}

function validButtonsAndBoxes() {
   // radio buttons (gender)
   if (document.querySelector('input[name="gender"]:checked') == null) {
      return false;
   }

   // checkboxes (permission level)
   if (document.querySelector('input[name="permission"]:checked') == null) {
      return false;
   }

   // multiple select (department)
   if (document.forms.register.department.selectedIndex < 0) {
      return false;
   }

   return true;
}

function validUserId() {
   let userID = document.forms.register.userID.value;
   let regex = /^([a-zA-Z_]){4,10}$/;

   // check user ID digits
   if (!regex.test(userID)) {
      document.register.userID.focus();
      return false;
   }

   return true;
}

function validPassword() {
   let password = document.forms.register.password.value;
   let confirmPassword = document.forms.register.confirmPassword.value;
   let regex = /^[a-zA-Z]([a-zA-Z0-9_]){6,9}$/;

   if (!regex.test(password)) {
      document.register.password.focus();
      return false;
   }

   if (password != confirmPassword) {
      document.register.confirmPassword.focus();
      return false;
   }

   return true;
}

function validEmail() {
   let email = document.register.email.value;

   // regex source: https://emailregex.com/
   let regex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;

   if (!email.match(regex)) {
      document.register.email.focus();
      return false;
   }

   return true;
}

function validateForm() {
   // check if all text input fields are filled out
   if (!validTextInputs()) {
      alert("All fields must be filled out")
      return false;
   }

   // check if radio buttons and checkboxes are checked
   if (!validButtonsAndBoxes()) {
      alert("Radio buttons and checkboxes must be checked");
      return false;
   }

   // check if user ID is valid (4-10 characters + only letters and "_")
   if (!validUserId()) {
      alert("User ID must be between 4 and 10 characters long and only the use of letters and \"_\" is possible");
      return false;
   }

   // check if password is valid (7-10 characters, starting with letter and) and both passwords match
   if (!validPassword()) {
      alert("Password must be between 7 and 10 characters long, only the use of letters, numbers and \"_\" is possible and both passwords must match.");
      return false;
   }

   // check if email is valid
   if (!validEmail()) {
      alert("Email is not valid")
      return false;
   }
}