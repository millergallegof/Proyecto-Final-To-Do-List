'use strict'
import getSubTareas from "./getSubTareas.js";

const $card = document.getElementById('tareas')

export default async function getTareas(url) {
    try {
        let res = await fetch(`${url}tarea`);
        let json = await res.json();
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }

        json.forEach(async element => {
            let subTarea = await getSubTareas(url, element.id)
            const $headerCard = document.createElement('div')
            $headerCard.classList.add("card-header")
            $headerCard.innerText = element.name
            $card.append(subTarea, $headerCard)
        });


    } catch (error) {
        console.log(error);

    }

}