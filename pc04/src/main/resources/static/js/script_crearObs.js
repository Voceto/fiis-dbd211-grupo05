const app = new Vue({
    el:'#creaobs',
    data:{
        cod_info:localStorage.getItem("cod_inf"),
        observacionRequest:{aasunto:"",contenido:"",inf_id:""},
        resp:""
    },
    methods:{
        crearObserv:function(){
            this.observacionRequest.inf_id=this.cod_info;
            axios.post('/creaObservacion',this.observacionRequest).then(response => (this.resp = response.data));
            console.log(this.observacionRequest.comentario);

        },
    },
})