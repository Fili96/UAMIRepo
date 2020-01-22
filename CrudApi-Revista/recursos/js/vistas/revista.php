<script>

/**
* Metodo para cargar Autores
* mediante una peticion HTTP Get
**/
let app = new Vue({
	el: '.vue-slider',
	data: {
		revistas: [],
		autores: [],
		paginas: [],
		revistas_autores: [],
		revistas_arbitros: [],
		total: 0,
		revistaActual: {},
		autoresActual: [],
		paginasActual: []
	},
	methods: {
		cambiarNumeroActual: (revista) => {

			cambiarDatos(revista)
			moverseActual()
		},
		getAutores: (idRevista) =>{

			let autoresActual = []
			let idsAutores = [];

			// Se filtran las revistas autores con el id de la revista correspondiente
			let r_a = app.revistas_autores.filter( r_a => idRevista == r_a["revista"])
			
			// Se obtienen los ids de los autores  en un arreglo
			r_a.forEach( revista_autor =>{
				idsAutores.push(revista_autor["author"])
			});
			
			// Se forma el arreglo de los autores en la revista
			idsAutores.forEach( idAutor => {
				let autor = app.autores.filter( autor => idAutor == autor["idAuthor"])[0]
				autoresActual.push(autor)
			});
			return autoresActual
		},
		getPaginas: (idIndice)=>{
			let paginas = app.paginas.filter( pagina => idIndice == pagina["Indice_idIndice"] )
			return paginas
		}
	}
});

const cargarRevistas = async () => {
	let url = '<?php echo base_url(); ?>api/revistas';

	await fetch( url )
		.then( (res) => res.json() )
		.then( (json) => {
			app.revistas = json.revistas
		});
}

const cargarAutores = async () => {
	let url = '<?php echo base_url(); ?>api/autores';

	await fetch( url )
		.then( (res) => res.json() )
		.then( (json) => {
			app.autores = json.autores
		});
}

const cargarPaginas = async () => {
	let url = '<?php echo base_url(); ?>api/paginas';

	await fetch( url )
		.then( (res) => res.json() )
		.then( (json) => {
			app.paginas = json.paginas
		});
}

const cargarRevistas_Autores = async () => {
	let url = '<?php echo base_url(); ?>api/revistas-autores';

	await fetch( url )
		.then( (res) => res.json() )
		.then( (json) => {

			app.revistas_autores = json["revistas-autores"]
			app.total = app.revistas_autores.length -1
			
			// Se obtienen los valores actuales
			let rev_aut = app.revistas_autores[app.total]
			let revista = app.revistas
								.filter( revista => rev_aut["revista"] == revista["numero"])[0]
			cambiarDatos(revista)
		});
}

const cambiarDatos = (revista)=>{
	app.revistaActual = revista
	app.autoresActual = app.getAutores(app.revistaActual.numero)
	app.paginasActual = app.getPaginas(app.revistaActual.Indice_idIndice)
}

const moverseActual = (id_elemento) => {

	let elemento = document.getElementById(id_elemento);
	window.location.href = '<?php echo base_url(); ?>#num-actual'
}

const previo = document.getElementById("previo")
const siguiente = document.getElementById("siguiente")
const carousel = document.getElementById("anteriores-slider")

previo.addEventListener("click", (e)=> {
	carousel.scrollLeft -= 210
	
})

siguiente.addEventListener("click", (e)=> {
	carousel.scrollLeft += 210
})


async function main() {
	await cargarRevistas();
	await cargarAutores();
	await cargarPaginas();
	await cargarRevistas_Autores();
}

main()
</script>