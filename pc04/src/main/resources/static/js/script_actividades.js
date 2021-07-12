const app = new Vue({
    el:'#actividades',
    data:{
        idProyecto:localStorage.getItem("cod_proy"),
        actividades:[],
        listaBand:true,
        actividadBand:false,
        actividad:null,
    },
    methods:{
        verLista:function(){
            this.actividadBand=false;
            this.listaBand=true;
            axios.post('/listaActividades',{ id: this.idProyecto }).then(response => (this.actividades = response.data));
        },
        verActividad:function(p1,p2){
            this.actividadBand=true;
            this.listaBand=false;
            axios.post('/obtenerActividad',{codigo:p1,codigo_tipo:p2}).then(response => (this.actividad=response.data));
            localStorage.setItem("cod_act",p1);
            localStorage.setItem("cod_tipo_act",p2);
        }
    },
    mounted () {
        this.verLista();
    },
})