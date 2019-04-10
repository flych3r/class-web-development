document.querySelector("#botaogerar").addEventListener("click",
    function() {
        var item = document.createElement("li");
        item.appendChild(document.createTextNode("Item"));
        document.querySelector("#lista").appendChild(item);
    }
);

document.querySelector("#botaoremover").addEventListener("click",
    function() {
        var lista = document.querySelector("#lista");
        lista.removeChild(lista.lastElementChild);
    }
);

document.querySelector("#botaoremover").addEventListener("dblclick",
    function() {
        var lista = document.querySelector("#lista");
        lista.innerHTML = "";
    }
);

document.querySelector("#calcular").addEventListener("click",
    function() {
        var num1 = document.querySelector("#numero1");
        var num2 = document.querySelector("#numero2");
        var res;
        switch(document.querySelector("#operacao").value) {
            case "+":
                res = parseInt(num1.value) + parseInt(num2.value);
                break;

            case "-":
                res = parseInt(num1.value) - parseInt(num2.value);
                break;

            case "*":
                res = parseInt(num1.value) * parseInt(num2.value);
                break;

            case "/":
                res = parseInt(num1.value) / parseInt(num2.value);
                break;
        }

        alert(res);
    }
);

document.querySelector("#enviar").addEventListener("click",
    function() {
        var form = document.querySelector("#formulario");
        var prod = form.nome.value;
        var preco = parseFloat(form.preco.value);
        var qtd = parseFloat(form.quantidade.value);
        var total = preco * qtd;

        var td1 = document.createElement("td");
        td1.innerHTML = prod;
        var td2 = document.createElement("td");
        td2.innerHTML = total;
        var tr = document.createElement("tr");
        tr.appendChild(td1);
        tr.appendChild(td2);

        var tabela = document.querySelector("#tabela");
        tabela.appendChild(tr);

        var novo = parseFloat(document.querySelector("#total").value);
        console.log(novo);
        document.querySelector("#total").value = novo + total;
    }
);
