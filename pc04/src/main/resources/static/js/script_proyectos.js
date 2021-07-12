localStorage.setItem("usuario","erzehorj")
const app = new Vue({
    el:'#proyectos',
    data:{
        username:localStorage.getItem("usuario"),
        ultProyBand:true,
        listaBand:false,
        proyBand:false,
        proyectos:[],
        proyUlt:{},
        proyecto:{}
    },
    methods:{
        verUltimoProy:function(){
            this.ultProyBand=true;
            this.listaBand=false;
            this.proyBand=false;
            axios.post('/obtenerUltimoProyecto',{id:this.username}).then(response => (this.ultProyBand=response.data))
        },
        verLista:function(){
            this.actividadBand=false;
            this.listaBand=true;
            this.proyBand=false;
            axios.post('/listaProyectos',{id:this.username}).then(response=>(this.proyectos=response.data))
        },
        verProyecto:function(cod){
            this.actividadBand=false;
            this.listaBand=false;
            this.proyBand=true;
            axios.post('/obtenerProyecto',{id:cod}).then(response=>(this.proyecto=response.data));
            localStorage.setItem("cod_proy",cod)
        }

    },
    mounted () {
            this.verLista();
    },
})