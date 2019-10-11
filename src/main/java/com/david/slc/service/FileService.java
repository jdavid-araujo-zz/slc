package com.david.slc.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.springframework.stereotype.Service;

import com.david.slc.model.Bcmsg;
import com.david.slc.model.GrupoLiquido;
import com.david.slc.model.GrupoLiquidoProduto;
import com.david.slc.model.GrupoProduto;
import com.david.slc.model.GrupoSequencia;
import com.david.slc.model.SisMsg;
import com.david.slc.model.Slc;

@Service
public class FileService {

	private final String URL_XML = "https://raw.githubusercontent.com/adquizilla/developer-challenge/master/SLC0001-modelo.xml";

	public Slc parse() {

		Slc slc = null;

		Bcmsg bcmsg = null;
		SisMsg sisMsg = null;
		GrupoLiquido grupoLiquido = null;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(URL_XML);

			doc.getDocumentElement().normalize();

			bcmsg = new Bcmsg(Long.parseLong(doc.getElementsByTagName("IdentdEmissor").item(0).getTextContent()),
					Long.parseLong(doc.getElementsByTagName("IdentdDestinatario").item(0).getTextContent()),
					new GrupoSequencia(Long.parseLong(doc.getElementsByTagName("NumSeq").item(0).getTextContent()),
							doc.getElementsByTagName("IndrCont").item(0).getTextContent()),
					doc.getElementsByTagName("DomSist").item(0).getTextContent(),
					doc.getElementsByTagName("NUOp").item(0).getTextContent());

			sisMsg = new SisMsg(doc.getElementsByTagName("CodMsg").item(0).getTextContent(),
					doc.getElementsByTagName("NumCtrlSLC").item(0).getTextContent(),
					doc.getElementsByTagName("ISPBIF").item(0).getTextContent(),
					doc.getElementsByTagName("TpInf").item(0).getTextContent(),
					new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
							.parse(doc.getElementsByTagName("DtHrSLC").item(0).getTextContent()),
					new SimpleDateFormat("yyyy-MM-dd")
							.parse(doc.getElementsByTagName("DtMovto").item(0).getTextContent()));

			grupoLiquido = new GrupoLiquido(
					new SimpleDateFormat("yyyy-MM-dd")
							.parse(doc.getElementsByTagName("DtLiquid").item(0).getTextContent()),
					Long.parseLong(doc.getElementsByTagName("NumSeqCicloLiquid").item(0).getTextContent()));

			NodeList nodeProdutoList = doc.getElementsByTagName("Grupo_SLC0001_Prodt");

			List<GrupoProduto> grupoProdutoList = new ArrayList<>();

			for (int i = 0; i < nodeProdutoList.getLength(); i++) {
				Node nodeProduto = nodeProdutoList.item(i);

				if (nodeProduto.getNodeType() == Node.ELEMENT_NODE) {

					Element elem = (Element) nodeProduto;
					GrupoProduto grupoProduto = new GrupoProduto(
							elem.getElementsByTagName("CodProdt").item(0).getTextContent());

					NodeList nodeLiquidoProdutoList = nodeProduto.getChildNodes();// getElementsByTagName("Grupo_SLC0001_LiquidProdt");

					List<GrupoLiquidoProduto> liquidoProdutoList = new ArrayList<>();

					for (int j = 0; j < nodeLiquidoProdutoList.getLength(); j++) {
						Node nodeLiquidoProduto = nodeLiquidoProdutoList.item(j);

						if (nodeLiquidoProduto.getNodeType() == Node.ELEMENT_NODE) {

							Element elem1 = (Element) nodeProduto;

							for (int k = 0; k < elem1.getElementsByTagName("IdentdLinhaBilat").getLength(); k++) {

								GrupoLiquidoProduto grupoLiquidoProduto = new GrupoLiquidoProduto(
										elem1.getElementsByTagName("IdentdLinhaBilat").item(k).getTextContent(),
										elem1.getElementsByTagName("TpDeb_Cred").item(k).getTextContent(),
										elem1.getElementsByTagName("ISPBIFCredtd").item(k).getTextContent(),
										elem1.getElementsByTagName("ISPBIFDebtd").item(k).getTextContent(),
										new BigDecimal(elem1.getElementsByTagName("VlrLanc").item(k).getTextContent()),
										elem1.getElementsByTagName("CNPJNLiqdantDebtd").item(k).getTextContent(),
										elem1.getElementsByTagName("NomCliDebtd").item(k).getTextContent(),
										elem1.getElementsByTagName("CNPJNLiqdantCredtd").item(k).getTextContent(),
										elem1.getElementsByTagName("NomCliCredtd").item(k).getTextContent(),
										Long.parseLong(
												elem1.getElementsByTagName("TpTranscSLC").item(k).getTextContent()));

								liquidoProdutoList.add(grupoLiquidoProduto);

							}

							break;

						}
					}
					grupoProduto.setGrupoLiquidoProduto(liquidoProdutoList);

					grupoProdutoList.add(grupoProduto);

				}
			}

			grupoLiquido.setGrupoProduto(grupoProdutoList);

			sisMsg.setGrupoLiquido(grupoLiquido);

			slc = new Slc(bcmsg, sisMsg);

		} catch (Exception ex) {

		}

		return slc;
	}
}
