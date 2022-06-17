import getTareas from "./components/getTareas.js";
import AppConfig from "./appConfig.js"
import createTarea from "./components/createTarea.js";
import deleteTarea from "./components/deleteTarea.js";
import createSubTarea from "./components/createSubTarea.js";
import updateSubTarea from "./components/updateSubTarea.js";



const d = document;
const $form = d.getElementById("formCreateTarea")


let url = AppConfig.urlBackend;
getTareas(url)

d.addEventListener('submit', async (e) => {
    e.preventDefault();

    if (e.target.nombreTarea.value) {
        if (e.target === $form) {
            await createTarea(url, e.target.nombreTarea.value);
        }
    } else {
        alert("ingrese el nombre de la tarea")
    }
})

d.addEventListener('click', async (e) => {
    if (e.target.matches(".btnDeleteTarea")) {
        deleteTarea(url, e.target.id);
    }

    if (e.target.matches(".btnCrearSub")) {
        let subTarea = e.target.parentElement.parentElement.children[1].value
        let idSubTarea = e.target.parentElement.parentElement.children[0].value;
        let idTarea = e.target.parentElement.parentElement.children[2].children[0].dataset.idTarea
        e.preventDefault();

        if (!idSubTarea) {
            createSubTarea(url, subTarea, e.target.id)
        } else {
            updateSubTarea(url, idSubTarea, subTarea, idTarea)
        }


    }

    if (e.target.matches("#edit")) {
        const $containerSub = d.querySelector(`#group${e.target.dataset.idTarea}`)
        $containerSub.children[2].children[0].textContent = 'Actualizar Tarea'
        $containerSub.children[0].value = e.target.dataset.id
        $containerSub.children[1].value = e.target.dataset.name
    }



})