/**
* comando para que el script se vuelva estricto para recibir y enviar importaciones
*/
'use strict'

/**
* elementos del DOM
*/
const $bodyCard = document.createElement('div')
$bodyCard.classList.add("card-body")

/**
* [funcion asincrona que hace una peticion http tipo fetch del metodo GET, 
*   con el cual se traen un elementos de una entidad especifica de la API
* ]
*
* @param url base de la direccion http o endpoint
* @param idTarea id del elemento a traer
* @throws Genera error al momento que el estado de la peticion es menor a 200 y mayor a 299
*
* @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
*
* @since [1.0.0]
*
*/
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