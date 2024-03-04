import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';

interface ServerResponse {
  ip: string[];
  date: string;
  time: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  date: Date | undefined;
  serverResponse: ServerResponse | undefined;

  constructor(private http: HttpClient) {}

  getHostInfo(event: MatDatepickerInputEvent<any>) {
    this.date = event.value;
    this.http
      .get<ServerResponse>('http://localhost:8080/host-info')
      .subscribe(
        res => this.serverResponse = res
      );
  }
}
