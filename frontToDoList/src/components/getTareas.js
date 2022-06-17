'use strict'

const $card = document.getElementById('cardTareas')
const $templateCard = document.getElementById('cards-template').content;
const $templateTable = document.getElementById('table-template').content;
const $fragment = document.createDocumentFragment();

export default async function getTareas(url) {
    try {
        let res = await fetch(`${url}tarea`);
        let json = await res.json();
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }

        json.forEach(element => {
            $templateCard.querySelector('.card-header').textContent = element.name
            $templateCard.querySelector('.card-header').setAttribute("id", element.id)
            $templateCard.querySelector('#body').innerHTML = "";
            $templateCard.querySelector('#body').append(mostrarSubTare(element.subTareas))
            let $clone = document.importNode($templateCard, true)
            $fragment.append($clone)

        });
        $card.append($fragment);

        function mostrarSubTare(elementos) {

            const $fragmentTable = document.createDocumentFragment();
            elementos.forEach(element => {
                $templateTable.querySelector(".id").textContent = element.id;
                $templateTable.querySelector(".nombre").textContent = element.name;
                $templateTable.querySelector(".completado").textContent = element.complete;
                $templateTable.querySelector("#edit").dataset.id = element.id;
                $templateTable.querySelector("#edit").dataset.name = element.name;
                $templateTable.querySelector("#delete").dataset.id = element.id;
                let $clone = document.importNode($templateTable, true);
                $fragmentTable.append($clone)
            });

            return $fragmentTable;
        }
    } catch (error) {
        console.log(error);
    }
}
