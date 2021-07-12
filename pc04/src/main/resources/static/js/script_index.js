const app = new Vue({
    el:'#proyectos',
    data:{
        usename:localStorage.getItem("usuario"),
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
            axios.post('/obtenerActividad',{codigo:p1,codigo_tipo:p2}).then(response => (this.actividad=response.data))
        },
        volverLista:function(){
            this.actividadBand=false;
            this.listaBand=true;
        }
    },
    mounted () {
        this.verUltimoProy,
    },
})