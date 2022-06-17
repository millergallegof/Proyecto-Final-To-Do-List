/**
* comando para que el script se vuelva estricto para recibir y enviar importaciones
*/
'use strict'

/**
* [funcion asincrona que hace una peticion http tipo fetch del metodo DELETE, 
*   con el cual se elimina un elemento en la API
* ]
*
* @param url base de la direccion http o endpoint
* @param idSubTarea id del elemento a eliminar
* @throws Genera error al momento que el estado de la peticion es menor a 200 y mayor a 299
*
* @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
*
* @since [1.0.0]
*
*/
export default async function deleteSubTarea(url, idSubTarea) {
    try {
        let options = {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }
        let res = await fetch(`${url}subTarea/delete/${idSubTarea}`, options)
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }
        location.reload();
    } catch (error) {
        console.log(error);
    }
}