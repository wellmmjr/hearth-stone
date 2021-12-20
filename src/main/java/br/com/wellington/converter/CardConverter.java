package br.com.wellington.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.wellington.data.model.Card;
import br.com.wellington.data.vo.CardVO;
import br.com.wellington.exception.ExceptionResponse;
import br.com.wellington.exception.ResourceNotFoundException;
import br.com.wellington.exception.handler.CustomizedResponseEntityHandlerException;

public class CardConverter {

	
	public static CardVO cardToVO(Card origin) {
		
		CardVO cardVO = new CardVO();
		
		cardVO.setId(origin.getId());
		cardVO.setNome(origin.getName());
		cardVO.setDescricao(origin.getDescription());
		cardVO.setAtaque(origin.getAtack());
		cardVO.setDefesa(origin.getDefense());
		cardVO.setTipo(origin.getType());
		cardVO.setClasse(origin.getClassCard());
		
		
		return cardVO;
		
	}
	
	public static List<CardVO> cardToVOList(List<Card> origin) {
		
		List<CardVO> destinationCardsVO = new ArrayList<CardVO>();
		
		for (Card cardsOrigin : origin) {
			destinationCardsVO.add(cardToVO(cardsOrigin));
		}
		
		return destinationCardsVO;
		
	}
	
	public static Card voToCard(CardVO origin) {
		
		Card card = new Card();
		
		card.setId(origin.getId());
		card.setName(origin.getNome());
		card.setDescription(origin.getDescricao());
		card.setAtack(origin.getAtaque());
		card.setDefense(origin.getDefesa());
		card.setType(origin.getTipo());
		card.setClassCard(origin.getClasse());
		
		
		return card;
		
	}

	public static List<Card> voToCardList(List<CardVO> origin) {
		
		List<Card> destinationCards = new ArrayList<Card>();
		
		for (CardVO cardsOrigin : origin) {
			destinationCards.add(voToCard(cardsOrigin));
		}
		
		return destinationCards;
		
	}
	
}
