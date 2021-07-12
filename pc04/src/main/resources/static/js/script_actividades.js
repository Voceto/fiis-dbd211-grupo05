
 const app = new Vue({
    el:'#actividades',
    data:{
        idProyecto:'B&PS-PAC-PC-0002',
        actividades:[],
        listaBand:true,
        actividadBand:false,
        actividad:{},
    },
    methods:{
        verActividad:function(p1,p2){
            this.actividadBand=true;
            this.listaBand=false;
            axios.post('/obtenerActividad',{codigo:p1,codigo_tipo:p2}).then(response => (this.actividad=response.data))
        },
        volverLista:function(){
            this.actividadBand=false;
            this.listaBand=true;
        }
    },
    mounted () {
        axios.post('/listaActividades',{ id: this.idProyecto }).then(response => (this.actividades = response.data))
    },
})