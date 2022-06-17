/**
* comando para que el script se vuelva estricto para recibir y enviar importaciones
*/
'use strict'

/**
* [funcion asincrona con la cual hace una peticion http tipo fetch del metodo POST, 
*   con el cual se actualiza una entidad de la API
* ]
*
* @param url base de la direccion http o endpoint
* @param idSubTarea id del elemento a modificar
* @param nameSubTarea atributo actualizar
* @param idTarea atributo actualizar
* @param completeSub atributo actualizar
* @throws Genera error al momento que el estado de la peticion es menor a 200 y mayor a 299
*
* @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
*
* @since [1.0.0]
*
*/
export default async function updateSubTarea(url, idSubTarea, nameSubTarea, idTarea, completeSub = false) {
    try {
        let options = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify({
                name: nameSubTarea,
                complete: completeSub,
                tareaTar: {
                    id: idTarea
                }
            })
        }
        let res = await fetch(`${url}subtarea/update/${idSubTarea}`, options)
        let json = await res.json()
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }

    } catch (error) {
        console.log(error);
    }


}