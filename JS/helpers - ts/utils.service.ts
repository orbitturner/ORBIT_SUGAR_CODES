import { Injectable } from '@angular/core';
import {NavigationEnd} from '@angular/router';

/**
 * ==============================
 * 🔰📡 SOME UTILITIES HELPER 📡🔰
 * ==============================
 */

@Injectable({
  providedIn: 'root'
})
export class UtilsService {
  // =================================================
  // ignores case-sensitive for Array Filter
  private getValue = (value: string) => (value.toUpperCase());
  // =================================================

  constructor() { }

  // =========================================================================
  // 💠🔹 OBJECT EXISTENCE VERIFIER HELPER🔹💠
  // =========================================================================
  /**
   * Verify if an Object exist or isn't Empty
   *
   * @param obj -> Testing Object
   */
  public isExisting(obj: any): boolean{
    if(obj){
      return Object.keys(obj).length > 0;
    }
    return false;
  }
  // *********************************************************** |


  // =========================================================================
  // 💠🔹 ARRAY OF A GIVEN SIZE CREATOR HELPER🔹💠
  // =========================================================================
  /**
   * Creates an Array of a given length for iteration
   * @param i -> The length of the array
   */
  public counter(i: number): any[] {
    return new Array(i);
  }
  // *********************************************************** |


  // =========================================================================
  // 💠🔹 SPRING BOOT DATE GETTER HELPER🔹💠
  // =========================================================================
  /**
   * Get the current date & Converts it to Spring Boot Java Date Format
   */
  public getTheCurrentDate(): any{
    /**
     * set the day with two number if the result of the day is with one number
     */
    const dayFormat = new Date().getDay().toString().length>0 ? `0${new Date().getDay()}` : new Date().getDay();

    /**
     * set the month with two number if the result of the day is with one number
     */
    const monthFormat = new Date().getMonth().toString().length>0 ? `0${new Date().getMonth()+1}` : new Date().getMonth()+1;

    return `${dayFormat}/${monthFormat}/${new Date().getFullYear()}`;
  }
  // *********************************************************** |


  // =========================================================================
  // 💠🔹 ARRAY FILTER / QUERY HELPER 🔹💠
  // =========================================================================

  /**
   * Filters an array of objects (one level-depth) with multiple criteria.
   *
   * @param  array   - The array to filter
   * @param  filters - An object with the filter criteria
   * @return array   - Found Elements
   */
  public filterPlainArray(array: any[], filters: { [x: string]: any[]; }): any[] {
    const filterKeys = Object.keys(filters);
    return array.filter(item => {
      // validates all filter criteria
      return filterKeys.every(key => {
        // ignores an empty filter
        if (!filters[key].length) { return true; }
        return filters[key].find(filter => this.getValue(filter) === this.getValue(item[key]));
      });
    });
  }
  // ************************************************************************|


  // =========================================================================
  // 💠🔹 LOCALSTORAGE WITH EXPIRY TIME HELPER🔹💠
  // =========================================================================
  /**
   * Here, we create a new object with the original value as well as the expiry time,
   * which is calculated by adding the TTL value in milliseconds
   * to the current millisecond time.
   *
   * @param key -> Object Key Name in the LS.
   * @param value -> Value of Object stored in Key.
   * @param ttl -> Expiry Time in Millisecond.
   */
  public setWithExpiry(key: string, value: any, ttl: any):void {
    const now = new Date();

    // `item` is an object which contains the original value
    // as well as the time when it's supposed to expire
    const item = {
      value,
      expiry: now.getTime() + ttl,
    };
    localStorage.setItem(key, JSON.stringify(item));
  }

  /**
   * Here we are expiring the item “lazily” - which is to say we check the expiry condition only
   * when we want to retrieve it from storage.
   * If the item has, in-fact expired, we remove the key from localStorage.
   *
   * @param key -> The Item To Retrieve from LS
   */
  public getWithExpiry(key: any): any {
    const itemStr = localStorage.getItem(key);
    // if the item doesn't exist, return null
    if (!itemStr) {
      return null;
    }
    const item = JSON.parse(itemStr);
    const now = new Date();
    // compare the expiry time of the item with the current time
    if (now.getTime() > item.expiry) {
      // If the item is expired, delete the item from storage
      // and return null
      localStorage.removeItem(key);
      return null;
    }
    return item.value;
  }
  // *********************************************************** |

// setTimeout(() =>{
  //   this.authService.setSessionTimeout();
  // },5000);
}
