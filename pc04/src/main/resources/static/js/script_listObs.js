const app = new Vue({
    el:'#obs',
    data:{
        cod_inf:localStorage.getItem("cod_inf"),
        observaciones:[],
    },
    methods:{
        verLista:function(){
            axios.post('/listaObservaciones',{ id: this.cod_inf }).then(response => (this.observaciones = response.data));
        },
        verObs:function(p1){
            localStorage.setItem("cod_obs",p1);
        },
        filtrarObs:function(){
            axios.post('/filtrarObservaciones',{id:this.cod_inf,fmin:document.getElementById("Fecha desde").value,fmax:document.getElementById("Fecha hasta").value}).then(response=>(this.observaciones=response.data));
        },
    },
    mounted () {
        this.verLista();
    },
})