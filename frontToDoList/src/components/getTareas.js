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
            const $buttonDelete = document.createElement('button')
            const $inputSubId = document.createElement('input')
            const $inputSub = document.createElement('input')
            const $containerSub = document.createElement('div')
            const $buttonSub = document.createElement('button')

            $buttonDelete.setAttribute("type", "button")
            $buttonDelete.setAttribute("id", element.id)
            $buttonDelete.classList.add('btnDeleteTarea', 'btn', 'btn-dark')
            $buttonDelete.textContent = `Eliminar`

            $inputSubId.setAttribute("type", 'hidden')
            $inputSubId.setAttribute("name", 'id')

            $inputSub.setAttribute("type", 'text')
            $inputSub.setAttribute("name", 'nombre')
            $inputSub.setAttribute("placeholder", 'SubTarea')
            $inputSub.classList.add("form-control")

            $containerSub.classList.add("input-group-append")

            $buttonSub.setAttribute("type", "button")
            $buttonSub.classList.add("btnCrearSub", "btn", "btn-secondary")
            $buttonSub.dataset.idTarea = element.id;
            $buttonSub.textContent = 'Crear SubTarea'

            $containerSub.appendChild($buttonSub)

            $templateCard.querySelector('.card-header').textContent = element.name
            $templateCard.querySelector('.card-header').setAttribute("id", element.id)
            $templateCard.querySelector('.card-header').append($buttonDelete)
            $templateCard.querySelector('.input-group').innerHTML = "";
            $templateCard.querySelector('.input-group').setAttribute("id", `group${element.id}`)
            $templateCard.querySelector('.input-group').append($inputSubId, $inputSub, $containerSub)
            $templateCard.querySelector('#body').innerHTML = "";
            $templateCard.querySelector('#body').append(mostrarSubTare(element.subTareas, element.id))
            let $clone = document.importNode($templateCard, true)
            $fragment.append($clone)

        });
        $card.append($fragment);

        function mostrarSubTare(elementos, idTarea) {

            const $fragmentTable = document.createDocumentFragment();
            elementos.forEach(element => {
                const $container = document.createElement('div')
                const $inputcomplete = document.createElement('input')

                $container.classList.add("form-check", "form-switch")

                $inputcomplete.classList.add("form-check-input")
                $inputcomplete.setAttribute("type", "checkbox")
                $inputcomplete.setAttribute("data-onstyle", "dark")
                $inputcomplete.setAttribute("role", "switch")
                $inputcomplete.setAttribute("id", "switch")
                $inputcomplete.dataset.id = element.id;
                $inputcomplete.dataset.name = element.name;
                $inputcomplete.dataset.idTarea = idTarea;

                $container.appendChild($inputcomplete)

                $templateTable.querySelector(".id").textContent = element.id;
                $templateTable.querySelector(".nombre").textContent = element.name;
                $templateTable.querySelector(".completado").innerHTML = ""
                $templateTable.querySelector(".completado").append($container);

                $templateTable.querySelector("#edit").dataset.id = element.id;
                $templateTable.querySelector("#edit").dataset.name = element.name;
                $templateTable.querySelector("#edit").dataset.idTarea = idTarea;
                $templateTable.querySelector("#delete").dataset.id = element.id;

                if (element.complete) {
                    $inputcomplete.checked = true
                    $templateTable.querySelector("#edit").disabled = true
                    $templateTable.querySelector(".nombre").style.color = "grey"
                } else {
                    $templateTable.querySelector("#edit").disabled = false
                    $templateTable.querySelector(".nombre").style.color = "black"
                }
                let $clone = document.importNode($templateTable, true);
                $fragmentTable.append($clone)
            });

            return $fragmentTable;
        }
    } catch (error) {
        console.log(error);
    }
}
