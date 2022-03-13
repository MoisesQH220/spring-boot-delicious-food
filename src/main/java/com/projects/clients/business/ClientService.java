package com.projects.clients.business;

import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.OfferResponse;

public interface ClientService {
  
  ClientResponse findClientInformation(String documentType, String documentNumber);
  
}
