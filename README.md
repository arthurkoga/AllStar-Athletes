# SportsJerseyKingdom 
Uma API de controle de uma loja online de camisas esportivas


## Endpoints

- Camisas 
    - [Listar Camisa](#listar-camisa)
    - [Detalhar](#detalhar-camisa)
    - [Cadastrar](#cadastrar-camisa)
    - [Apagar](#apagar-camisa)
    - [Editar](#editar-camisa)

- Vendas
    - [Listar vendas](#listar-vendas)
    - [Detalhar](#detalhar-venda)
    - [Cadastrar](#cadastrar-venda)
    - [Editar](#editar-venda)


### Listar Camisa
`GET` / Camisa

Retornar um array com todas as camisas cadastradas na loja.

**Exemplo de Resposta**
```js
[
    {
        "id": 1,
        "nome": "Manchester United Home 23/24"
        "marca": "Nike"
        "tamanho": "G",
        "preco": 50
    }
]
```
**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso

---

### Detalhar Camisa

`GET` /Camisa/{id}  

Retornar os dados da camisa com o `id` informado.

**Exemplo de Resposta**
```js
{
    "id": 1,
    "nome": "Girona Home 23/24"
    "marca": "Nike"
    "tamanho": "G",
    "preco": 50
    "foto": "Arquivo/Imagens/Girona_Home_23/24"
}
```
**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|404| Id da Camisa não encontrado 

---

### Cadastrar Camisa

`POST` /Camisa

Insere uma nova Camisa

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|:-----:|:----:|:-----------:|---------
|nome|string| ✅ |Nome da camisa 
|marca | string | ✅ | Marca da camisa especifica
|tamanho | string | ✅  | Tamanho da camisa com no máximo 2 caracteres
| preco | float | ✅ | preco unitario do produto
| foto | string | ✅ | Fotos da camisa

```js
{
    "nome": "Girona Home 23/24"
    "marca": "Nike"
    "tamanho": "G",
    "preco": 50
    "foto": "Arquivo/Imagens/Girona_Home_23/24"
}
```
**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "Girona Home 23/24"
    "marca": "Nike"
    "tamanho": "G",
    "preco": 50
    "foto": "Arquivo/Imagens/Girona_Home_23/24"
}
```

**Códigos de Status**
| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|400| Erro de validação - verifique o corpo da requisição
---

### Apagar Camisa
`DELETE` /camisa/{id} 

Apagar a Camisa com o `id` indicado

**Códigos de Status**

| código | descrição|
|--------|----------|
|204| Camisa apagada com sucesso
|404| Id da camisa não encontrado 

--- 

### Editar Camisa

`PUT` /camisa

Atualizar os dados do `id` indicado

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|:-----:|:----:|:-----------:|---------
|nome|string| ✅ |Nome da camisa 
|marca | string | ✅ | Marca da camisa especifica
|tamanho | string | ✅  | Tamanho da camisa com no máximo 2 caracteres
| preco | float | ✅ | preco unitario do produto
| foto | string | ✅ | Fotos da camisa

```js
{
    "nome": "Girona Home 23/24"
    "marca": "Nike"
    "tamanho": "G",
    "preco": 50
    "foto": "Arquivo/Imagens/Girona_Home_23/24"
}
```

**Exemplo de Resposta**

```js
{
    "id": 1,
    "nome": "Girona Home 23/24"
    "marca": "Nike"
    "tamanho": "G",
    "preco": 50
    "foto": "Arquivo/Imagens/Girona_Home_23/24"
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200| Camisa atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da camisa não encontrado

---

## Listar Vendas

`GET` / venda 

Retorna um array com todas as vendas feitas

**Exemplo de Resposta**

```js
[
    {
    "id": 1,
    "código de rastreio": 239932 
    "nome cliente": "Arthur Koga",
    "produto": "Girona home 23/24"
    "endereço": "Av.Paulista 1203"
    "Valor": 79.50
    "Enviado": false
    }
]
```
**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso

--- 

## Detalhar Venda

`GET` /venda/{id}

Retornar os dados da venda com o `id` informado

```js
{
    "id": 1,
    "código de rastreio": 239932 
    "nome cliente": "Arthur Koga",
    "produto": "Girona home 23/24"
    "endereço": "Av.Paulista 1203"
    "Valor": 79.50
    "Enviado": false
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200| Dados retornados com sucesso
|404| Id da venda não encontrado 

--- 

### Cadastrar venda 

`POST` /venda

Insere uma nova venda.

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|:-----:|:----:|:-----------:|---------
|nome cliente | string | ✅ | Nome completo
|produto | string | ✅ | Nome da produto
|endereco | string | ✅ | Endereço completo 
|valor | float | ✅ | Valor da venda 

```js
 {
    "nome cliente": "Arthur Koga",
    "produto": "Girona home 23/24"
    "endereço": "Av.Paulista 1203"
    "Valor": 79.50
}
``` 

**Exemplo de Resposta**

```js
{
    "id": 1,
    "código de rastreio": 239932 
    "nome cliente": "Arthur Koga",
    "produto": "Girona home 23/24"
    "endereço": "Av.Paulista 1203"
    "Valor": 79.50
    "Enviado": false
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200|Dados retornados com sucesso
|400| Erro de validação - verifique o corpo da requisição

---

### Editar venda 

`PUT` /venda

Atualizar os dados do `id` indicado

**Corpo da requisição**

|campo|tipo|obrigatório|descrição
|:-----:|:----:|:-----------:|---------
|endereco | string | ✅ | Endereço completo
|enviado | boolean | ✅ | alterar status do pedido

```js
{
    "nome": "alimentação",
    "endereço": "Av.Paulista 1203"
    "Enviado": false
}
```
**Exemplo de Resposta**

```js
{
    "id": 1,
    "código de rastreio": 239932 
    "nome cliente": "Arthur Koga",
    "produto": "Girona home 23/24"
    "endereço": "Av.Paulista 1203"
    "Valor": 79.50
    "Enviado": true
}
```

**Códigos de Status**

| código | descrição|
|--------|----------|
|200| Venda atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da venda não encontrado

---
