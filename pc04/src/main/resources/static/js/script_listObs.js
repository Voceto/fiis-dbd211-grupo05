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
        }
    },
    mounted () {
        this.verLista();
    },
})