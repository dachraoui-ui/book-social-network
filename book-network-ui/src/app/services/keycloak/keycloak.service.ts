import { Injectable } from '@angular/core';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {

  private _keycloak: Keycloak | undefined;

  get keycloak() {
    if(!this._keycloak) {
      this._keycloak = new Keycloak({
        url: 'http://localhost:9090/auth',
        realm: 'book-social-network',
        clientId: 'bsn'
      })
    }
    return this._keycloak
  }

  constructor() { }

  async init() {
    console.log('Authenticating...')
    const authenticated = await this.keycloak.init({
      onLoad: 'login-required',
    })

    if(authenticated) {
      console.log('User Authenticated')
    }
  }
}
