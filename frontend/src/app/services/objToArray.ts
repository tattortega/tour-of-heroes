import { Pipe, PipeTransform } from "@angular/core";
import {Hero} from "./hero";

@Pipe({
    name: 'ObjetToArray'
})
export class ObjetToArray implements PipeTransform{
    transform(objet: Hero[] = []): Hero[] {
        return Object.values(objet);
    }
}
