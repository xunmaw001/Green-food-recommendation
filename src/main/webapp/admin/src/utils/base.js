const base = {
    get() {
        return {
            url : "http://localhost:8080/lvseshipintuijian/",
            name: "lvseshipintuijian",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lvseshipintuijian/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "绿色食品推荐"
        } 
    }
}
export default base
