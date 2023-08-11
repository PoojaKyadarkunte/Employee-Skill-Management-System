import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email!:any;
  password!:any;
  constructor(private router:Router){}
  check(){
    this.email = document.getElementById('email');
    this.password = document.getElementById('password');

    if(this.email.value==="manager@gmail.com" && this.password.value==="manager@123"){
        alert("Login Successfull");
        localStorage.setItem("token",this.email.value);
       this.router.navigate(['/']);
    }else{
      alert("Enter valid email!!");
      this.email.value='';
      this.password.value='';
    }
  }
}
