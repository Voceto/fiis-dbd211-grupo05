const app = new Vue({
    el:'#informes',
    data:{
        cod_act:localStorage.getItem("cod_act"),
        cod_tipo_act:localStorage.getItem("cod_tipo_act"),
        informes:[],
        listaBand:true,
        informeBand:false,
        informe:null,
    },
    methods:{
        verLista:function(){
            this.informeBand=false;
            this.listaBand=true;
            axios.post('/listainforme',{ codigo: this.cod_act,codigo_tipo:this.cod_tipo_act }).then(response => (this.informes = response.data));
        },
        verInforme:function(p1){
            this.informeBand=true;
            this.listaBand=false;
            axios.post('/obtenerInforme',{id:p1}).then(response => (this.informe=response.data));
            localStorage.setItem("cod_inf",p1);
        },
        filtrarInforme:function(){
            axios.post('/filtrarinforme',{codigo:this.cod_act,codigo_tipo:this.cod_tipo_act,fmin:document.getElementById("Fecha desde").value,fmax:document.getElementById("Fecha hasta").value}).then(response=>(this.informes=response.data));
        }
    },
    mounted () {
        this.verLista();
    },
})