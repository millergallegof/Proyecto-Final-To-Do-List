'use strict'

const $bodyCard = document.createElement('div')
$bodyCard.classList.add("card-body")

export default async function getSubTareas(url, idTarea) {
    try {
        let res = await fetch(`${url}buscarSubtarea/tarea/${idTarea}`);
        let json = await res.json();
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }

        json.forEach(element => {
            const $p = document.createElement('p');
            $p.innerHTML = element.name;
            $bodyCard.append($p);
        });

        return $bodyCard;
    } catch (error) {
        console.log(error);
        return null
    }

}