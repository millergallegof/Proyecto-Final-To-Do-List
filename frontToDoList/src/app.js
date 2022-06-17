import getTareas from "./components/getTareas.js";
import AppConfig from "./appConfig.js"
import createTarea from "./components/createTarea.js";
import deleteTarea from "./components/deleteTarea.js";
import createSubTarea from "./components/createSubTarea.js";
import updateSubTarea from "./components/updateSubTarea.js";
import deleteSubTarea from "./components/deleteSubTarea.js";


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
            createSubTarea(url, subTarea, idTarea)
        } else {
            updateSubTarea(url, idSubTarea, subTarea, idTarea)
            location.reload();
        }

    }

    if (e.target.matches("#edit")) {
        const $containerSub = d.querySelector(`#group${e.target.dataset.idTarea}`)
        $containerSub.children[2].children[0].textContent = 'Actualizar Tarea'
        $containerSub.children[0].value = e.target.dataset.id
        $containerSub.children[1].value = e.target.dataset.name
    }

    if (e.target.matches("#delete")) {
        deleteSubTarea(url, e.target.dataset.id)
    }

    if (e.target.matches("#switch")) {
        const buttonEditar = e.target.parentElement.parentElement.parentElement.children[3].children[0]
        const textsub = e.target.parentElement.parentElement.parentElement.children[1]
        let complete = e.target.checked
        let idSubTarea = e.target.dataset.id
        let subTarea = e.target.dataset.name
        let idTarea = e.target.dataset.idTarea
        if (complete) {
            buttonEditar.disabled = true;
            textsub.style.color = "grey";
        } else {
            buttonEditar.disabled = false;
            textsub.style.color = "black";
        }

        updateSubTarea(url, idSubTarea, subTarea, idTarea, complete)


    }
})
