'use strict'

export default async function deleteTarea(url, idTarea) {
    try {
        let options = {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }
        let res = await fetch(`${url}tarea/delete/${idTarea}`, options)
        if (!res.ok) throw new { status: res.status, statusText: res.statusText }
        location.reload();
    } catch (error) {
        console.log(error);
    }
}