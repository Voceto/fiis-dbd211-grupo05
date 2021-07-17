const app = new Vue({
    el:'#proyectos',
    data:{
        username:localStorage.getItem("usuario"),
        ultProyBand:true,
        listaBand:false,
        proyBand:false,
        proyectos:[],
        proyUlt:{},
        proyecto:{},
        fecha_text:""
    },
    methods:{
        verUltimoProy:function(){
            this.ultProyBand=true;
            this.listaBand=false;
            this.proyBand=false;
            axios.post('/obtenerUltimoProyecto',{id:this.username}).then(response => (this.proyUlt=response.data))
        },
        verLista:function(){
            this.ultProyBand=false;
            this.listaBand=true;
            this.proyBand=false;
            axios.post('/listaProyectos',{id:this.username}).then(response=>(this.proyectos=response.data))
        },
        verProyecto:function(cod){
            this.ultProyBand=false;
            this.listaBand=false;
            this.proyBand=true;
            axios.post('/obtenerProyecto',{id:cod}).then(response=>(this.proyecto=response.data));
            localStorage.setItem("cod_proy",cod)
        },
        filtrarProyecto:function(){
            axios.post('/filtroProyectos',{id:this.username,fmin:document.getElementById("Fecha desde").value,fmax:document.getElementById("Fecha hasta").value}).then(response=>(this.proyectos=response.data));
        },
    },
    mounted () {
            this.verUltimoProy();
    },
})