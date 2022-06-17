'use strict'
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