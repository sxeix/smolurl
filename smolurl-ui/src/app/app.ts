import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CreateResponse, HttpService } from './http-service';
import { catchError, of, Subject, switchMap } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {

  private httpService = inject(HttpService);

  urlInput = new FormControl('');

  private generateSubject = new Subject<string>();

  generatedUrlId$ = this.generateSubject.pipe(
    switchMap((url) =>
      this.httpService.postCreate(url).pipe(
        catchError((error) => {
          console.error('Error creating short URL:', error);
          return of(null);
        })
      )
    )
  );

  generateUrl() {
    const url = this.urlInput.value;
    if (url) {
      this.generateSubject.next(url);
    } else {
      console.warn('URL input is empty');
    }
  }

  getGeneratedUrl(generatedUrlId: CreateResponse): string {
    if (!generatedUrlId || !generatedUrlId.id) {
      return '';
    }
    return `${window.location.origin}/${generatedUrlId.id}`;
  }

}
