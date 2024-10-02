package com.jesustyle.application.util;

import com.jesustyle.application.entidade.pagamento.Items;
import com.jesustyle.application.entidade.pagamento.PedidoDTO;
import com.jesustyle.application.entidade.transporte.solicitar.request.*;
import com.jesustyle.application.repository.entity.PedidoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapOrderToTransporte {
    public TransporteRequest mapOrderToTransporteRequest(PedidoEntity order, String referencia, PedidoDTO pedidoDto) {

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

        if (!pedidoDto.getPayments().isEmpty()) {
            var payment = pedidoDto.getPayments().get(0).getCredit_card().getCard().getBillingAddress();

            String endereco = payment.getLine1();
            String numero = payment.getLine1();
            String complemento = payment.getLine1();
            String bairro = payment.getLine1();

            Endereco enderecoDestinatario = new Endereco(
                    !endereco.isEmpty() ? endereco : "",
                    !numero.isEmpty() ? numero : "0",
                    !complemento.isEmpty() ? numero : "N/A",
                    !bairro.isEmpty() ? numero : "",
                    payment.getZipCode(),
                    payment.getCity(),
                    payment.getState()
            );

            destinatario.setEndereco(enderecoDestinatario);
            destinatario.setContato(order.getCustomer().getName());
            destinatario.setEmail(order.getCustomer().getEmail());
            destinatario.setTelefone(order.getCustomer().getPhones().getHomePhone().getAreaCode() + order.getCustomer().getPhones().getHomePhone().getNumber());
            destinatario.setCelular(order.getCustomer().getPhones().getHomePhone().getAreaCode() + order.getCustomer().getPhones().getHomePhone().getNumber());
            transporteRequest.setDestinatario(destinatario);
        }

        // Volumes (Baseado nos itens do pedido)
        List<Volume> volumes = new ArrayList<>();
        if (!order.getItems().isEmpty()) {
            var ii = order.getItems().get(0); // Change here
            Volume volume = new Volume();
            volume.setPeso(ii.getQuantity());
            volume.setAltura(1);
            volume.setLargura(1);
            volume.setComprimento(1);
            volume.setTipo("C");
            volume.setProduto(ii.getDescription());
            volume.setValor(ii.getAmount() / 100.0);
            volume.setQuantidade(ii.getQuantity());
            volumes.add(volume);
        }

        transporteRequest.setVolumes(volumes);

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
