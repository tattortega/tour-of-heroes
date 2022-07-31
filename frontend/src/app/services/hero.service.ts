import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {catchError, Observable, of, tap} from 'rxjs';

import { Hero } from './hero';
import { HEROES } from './mock-heroes';
import { MessageService } from './message.service';

@Injectable({ providedIn: 'root' })
export class HeroService {

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  private heroesUrl = 'api/hero';  // URL to web api
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
    })
  }

  getHeroes(): Observable<Hero[]> {
    return this.http
      .get<Hero[]>(this.heroesUrl)
      .pipe(
        tap(_ => this.log('fetched heroes')),
        catchError(this.handleError<Hero[]>('getHeroes', []))
      );
  }

  getHero(id: string|null): Observable<Hero> {
    const url = `${this.heroesUrl}/${id}`;
    return this.http
      .get<Hero>(url)
      .pipe(
        tap(_ => this.log(`fetched hero id = ${id}`)),
        catchError(this.handleError<Hero>(`getHero id = ${id}`))
      );
  }

  addHero(hero: Hero): Observable<Hero> {
    const url = `${this.heroesUrl}`;
    return this.http
      .post<Hero>
      (url, hero, this.httpOptions)
      .pipe(
        tap((newHero: Hero) => this.log(`added hero w/ id = ${newHero.id}`)),
        catchError(this.handleError<Hero>('addHero'))
      );
  }

  deleteHero(id: number): Observable<Hero> {
    const url = `${this.heroesUrl}/${id}`;
    return this.http
      .delete<Hero>(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`deleted hero id = ${id}`)),
        catchError(this.handleError<Hero>('deleteHero'))
      )
  }

  updateHero(hero: Hero): Observable<any> {
    const completed = `${this.heroesUrl}/${hero.id}`
    return this.http
      .put(completed,
        hero, this.httpOptions)
      .pipe(
        tap(_ => this.log(`updated hero id = ${hero.id}`)),
        catchError(this.handleError<any>('updateHero'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    }
  }

  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

  searchHero(term: string): Observable<Hero[]> {
    if (!term.trim()) return of([]);

    return this.http
      .get<Hero[]>(`${this.heroesUrl}/?name=${term}`)
      .pipe(
        tap(x => x.length ?
          this.log(`found heroes matching "${term}"`) :
          this.log(`no heroes matching "${term}"`)),
        catchError(this.handleError<Hero[]>('searchHeroes', []))
      )
  }
}
