'use strict'
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
        location.reload();
    } catch (error) {
        console.log(error);
    }


}