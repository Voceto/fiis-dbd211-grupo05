const app = new Vue({
    el:'#informes',
    data:{
        cod_act:localStorage.getItem("cod_act"),
        cod_tipo_act:localStorage.getItem("cod_tipo_act"),
        informes:[],
        listaInf:true,
        informeBand:false,
        creaObs:false,
        informe:null,
    },
    methods:{
        verLista:function(){
            this.informeBand=false;
            this.listaBand=true;
            this.creaObs=false;
            axios.post('/listainforme',{ codigo: this.cod_act,codigo_tipo:this.cod_tipo_act }).then(response => (this.informes = response.data));
        },
        verInforme:function(p1){
            this.informeBand=true;
            this.listaBand=false;
            this.creaObs=false;
            axios.post('/obtenerInforme',{id:p1}).then(response => (this.informe=response.data));
            localStorage.setItem("cod_inf",p1);
        }
    },
    mounted () {
        this.verLista();
    },
})