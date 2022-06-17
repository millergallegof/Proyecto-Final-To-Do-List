'use strict'

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