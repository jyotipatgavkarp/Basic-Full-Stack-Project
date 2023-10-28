import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Waiting';
constructor(private http:HttpClient)
{

}

url='http://15.207.88.89:8080/hotelwithregister/';
//url='http://localhost:8080/';

obj:Customer= new Customer();
names:Customer[]=[];
login:number=0;
username:string='';
password:string='';

// loginM()
// {
// console.log('in login');

// let url2=this.url+'logged/'+this.username+'and'+this.password;
// this.http.get(url2).subscribe((data:any)=>
// {
//   if(data==1)
//   {
//     this.loginv=1;
//   }
//   else 
//   {
//     window.alert("username or password is wrong");
//   }
// });

loginMethod() {
  console.log('in login');
 // let url2 = `${this.url}logged/${this.username}and${this.password}`;
  let url2=this.url+'logged/'+this.username+'and'+this.password;
  this.http.get(url2).subscribe((data: any) => {
    if (data == 0) {
      window.alert('username wrong');
      
    }
    else if(data==1)
    {
      window.alert('password is wrong');
    }
    else if(data==2)
    {
      window.alert('account not acitve');
    }
    else if (data==3)
    {
      window.alert('login successful');
      this.login=1;
    }
    else 
    {
      window.alert('something went wrong');
    }
    
  });
}

ShowRegistrationForm:number=0;
showRegister()
{
  this.ShowRegistrationForm=1;
}
rname:string='';
rusername:string='';
rpassword:string='';
rmobile:number=0;
register()
{

  let obj={
    'name':this.rname,
    'password':this.rpassword,
    'username':this.rusername,
    'mobile':this.rmobile
  }

  let url2=this.url+'register';
  this.http.post(url2,obj).subscribe((data: any) => {
    if (data) {
      window.alert('done');
    }
    else 
    {
      window.alert('something is wrong');
    }
  });

}
}
