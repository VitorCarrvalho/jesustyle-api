package com.jesustyle.application.util;

import com.jesustyle.application.entidade.pagamento.Items;
import com.jesustyle.application.entidade.pagarme.Order;
import com.jesustyle.application.entidade.transporte.solicitar.request.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MapOrderToTransporte {
    public TransporteRequest mapOrderToTransporteRequest(Order order, String referencia) {


        TransporteRequest transporteRequest = new TransporteRequest();

        // Definir valores básicos
        transporteRequest.setGerarPdf(false);
        transporteRequest.setFormatoPdf("");

        // Pedido
        Pedido pedido = new Pedido();
        pedido.setTipo("D");
        pedido.setNumero(order.getCode());
        pedido.setSerie("1");
        pedido.setVlrMerc(order.getAmount() / 100.0);
        pedido.setPesoMerc(calculateTotalWeight(order.getItems()));
        transporteRequest.setPedido(pedido);

        // Remetente - Valores fixos.
        Remetente remetente = new Remetente();
        remetente.setNome("Jesustyle Oficial");
        remetente.setCnpjCpf("38320809000173");
        Endereco enderecoRemetente = new Endereco("Rua Quiruá", "166", "Loja", "Suru", "06509012", "Santana de Parnaíba", "SP");
        remetente.setEndereco(enderecoRemetente);
        remetente.setContato("Contato Jesustyle");
        remetente.setEmail("contato@jesustyleoficial.com.br");
        remetente.setTelefone("11962149094");
        remetente.setCelular("11962149094");
        transporteRequest.setRemetente(remetente);

        // Destinatário
        Destinatario destinatario = new Destinatario();
        destinatario.setNome(order.getCustomer().getName());
        destinatario.setCnpjCpf(order.getCustomer().getDocument());
        Endereco enderecoDestinatario = new Endereco(
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getLine_1(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getNumber(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getComplement(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getDistrict(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getZipCode(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getCity(),
                order.getCharges().get(0).getLastTransaction().getCard().getBillingAddress().getState());

        destinatario.setEndereco(enderecoDestinatario);
        destinatario.setContato(order.getCustomer().getName());
        destinatario.setEmail(order.getCustomer().getEmail());
        destinatario.setTelefone(order.getCustomer().getPhones().getHome_phone().getArea_code() + order.getCustomer().getPhones().getHome_phone().getNumber());
        destinatario.setCelular(order.getCustomer().getPhones().getHome_phone().getArea_code() + order.getCustomer().getPhones().getHome_phone().getNumber());
        transporteRequest.setDestinatario(destinatario);

//        // Volumes (Baseado nos itens do pedido)
//        List<Volume> volumes = new ArrayList<>();
//        for (Items item : order.getItems()) {
//            Volume volume = new Volume();
//            volume.setPeso(item.getQuantity());
//            volume.setAltura(1);
//            volume.setLargura(1);
//            volume.setComprimento(1);
//            volume.setTipo("C");
//            volume.setProduto(item.getDescription());
//            volume.setValor(item.getAmount() / 100.0);
//            volume.setQuantidade(item.getQuantity());
//            volumes.add(volume);
//        }
//        transporteRequest.setVolumes(volumes);

        // Produtos (Baseado nos itens do pedido)
        List<Produto> produtos = new ArrayList<>();
        for (Items item : order.getItems()) {
            Produto produto = new Produto();
            produto.setPeso(item.getQuantity());
            produto.setAltura(0.30);
            produto.setLargura(0.30);
            produto.setComprimento(0.30);
            produto.setProduto(item.getDescription());
            produto.setValor(item.getAmount() / 100.0);
            produto.setQuantidade(item.getQuantity());
            produtos.add(produto);
        }
        transporteRequest.setProdutos(produtos);

        // Ponto de postagem e entrega
        transporteRequest.setPontoPostagem("32545122000150");
        transporteRequest.setPontoEntrega("21364453000177");

        // Transportadora e referência
        transporteRequest.setTransportadora("Correios Sedex");
        transporteRequest.setReferencia(referencia);

        // Usar transportadora contrato e serviços
        transporteRequest.setUsarTransportadoraContrato(false);
        transporteRequest.setServicos(List.of("E"));

        return transporteRequest;
    }
    private double calculateTotalWeight(List<Items> items) {
        double totalWeight = 0;
        for (Items item : items) {
            totalWeight += item.getQuantity();
        }
        return totalWeight;
    }
}
