package br.com.wellington.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

import br.com.wellington.converter.CardConverter;
import br.com.wellington.data.model.Card;
import br.com.wellington.data.model.enumType.ClassCardEnum;
import br.com.wellington.data.model.enumType.TypeCardEnum;
import br.com.wellington.data.vo.CardVO;
import br.com.wellington.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CardService {

public final AtomicLong idCounter = new AtomicLong();
	
	public static Map<Long, Card> deckOfCards = new HashMap<Long, Card>();
	
	public CardVO findById(long id) {
		
		Card card = deckOfCards.get(id);
		
		CardVO cardVO = new CardVO();
		if(card != null) {
			cardVO = CardConverter.cardToVO(card);
		}else {
			throw(new ResourceNotFoundException("no records found for this id"));
		}
		
		return cardVO;
	}
	
	public List<CardVO> findByName(final String nameCard) {
		
		final List<CardVO> cardSearchResult = new ArrayList<CardVO>();
		
		deckOfCards.forEach(new BiConsumer<Long, Card>() {
			public void accept(Long key, Card value) {
				if(value.getName().toLowerCase().equals(nameCard.toLowerCase())) {
					cardSearchResult.add(CardConverter.cardToVO(value));
				}
			}
		});
		
		return cardSearchResult;
	}
	
	public List<CardVO> findByClass(final String classCard) {
		
		final List<CardVO> cardSearchResult = new ArrayList<CardVO>();
		
		deckOfCards.forEach(new BiConsumer<Long, Card>() {
			public void accept(Long key, Card value) {
				if(value.getClassCard().equals(ClassCardEnum.valueOf(classCard.toUpperCase()))) {
					cardSearchResult.add(CardConverter.cardToVO(value));
				}
			}
		});
		
		return cardSearchResult;
	}

	public List<CardVO> findByType(final String typeCard) {
	
		final List<CardVO> cardSearchResult = new ArrayList<CardVO>();
		
		deckOfCards.forEach(new BiConsumer<Long, Card>() {
			public void accept(Long key, Card value) {
				if(value.getType().equals(TypeCardEnum.valueOf(typeCard.toUpperCase()))) {
					cardSearchResult.add(CardConverter.cardToVO(value));
				}
			}
		});
		
		return cardSearchResult;
	}
	
	public List<CardVO> listAll() {
		final List<Card> listOfCards = new ArrayList<Card>();
		
		deckOfCards.forEach(new BiConsumer<Long, Card>() {
			public void accept(Long key, Card value) {
				listOfCards.add(value);
			}
		});
		return CardConverter.cardToVOList(listOfCards);
		
	}
	
	public CardVO createCard(CardVO cardVO) {
		
		Card card = CardConverter.voToCard(cardVO);
		
		cardVerificator(card);
		
		final long generatedId = idCounter.incrementAndGet();

		card.setId(generatedId);
		
		deckOfCards.put(generatedId, card);
		
		return CardConverter.cardToVO(card);
	}
	
	public void deleteCard(long id) {
		
		CardVO entity = findById(id);
		deckOfCards.remove(entity.getId());
		
	}
	

	private void cardVerificator(Card card) {
		
		if (card.getName() == null) {
			throw(new ResourceNotFoundException("set card's info"));
		}
		if (card.getAtack() < 0 || card.getAtack() > 10) {
			throw(new ResourceNotFoundException("attack invalid  pontuation"));
		}
		if (card.getDefense() < 0 || card.getDefense() > 10) {
			throw(new ResourceNotFoundException("defense invalid pontuation"));
		}
		
		return;
	}
	
}
