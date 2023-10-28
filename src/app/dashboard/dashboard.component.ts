import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../customer';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  constructor(private http:HttpClient)
  {
  }

url='http://15.207.88.89:8080/hotelwithregister/';
//url='http://localhost:8080/';
obj:Customer= new Customer();
names:Customer[]=[];
add()
{
     console.log(this.obj);
     let url2=this.url+'add'; 
     this.http.post(url2,this.obj).subscribe((data:any)=>{
     this.names.push(data);
     this.obj = new Customer();
  })
}
load()
{
   console.log('in load');
   this.http.get(this.url+'load').subscribe((data:any)=>{
     this.names=data;
   });
}
delete(obj:Customer)
{
  console.log('in delete');
  let url2=this.url+'delete'+obj.id;
  this.http.get(url2).subscribe((data:any)=>
  {
    if(data==true)
    {
      let index=this.names.indexOf(obj);
      this.names.splice(index,1);

    }
    else 
    {
      window.alert('something is wrong');
    }
  });

}


}
