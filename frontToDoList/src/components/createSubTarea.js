/**
* comando para que el script se vuelva estricto para recibir y enviar importaciones
*/
'use strict'

/**
* [funcion asincrona que hace una peticion http tipo fetch del metodo POST, 
*   con el cual se crea un elemento de la entidad Tarea en la API
* ]
*
* @param url direccion con la base del endpoint
* @param nameSubTarea valor de uno de los atributos del objeto a crear
* @param idTarea valor del id de la entidad con la que serelaciona
* @throws Genera error al momento que el estado de la peticion es menor a 200 y mayor a 299
*
* @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
*
* @since [1.0.0]
*
*/
export default async function createSubTarea(url, nameSubTarea, idTarea) {
    try {
        let options = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify({
                name: nameSubTarea,
            })
        }
        let res = await fetch(`${url}subTarea/${idTarea}`, options)
        let json = await res.json()
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }
        location.reload();
    } catch (error) {
        console.log(error);
    }


}