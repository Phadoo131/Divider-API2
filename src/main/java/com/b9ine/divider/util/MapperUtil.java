package com.b9ine.divider.util;

import com.b9ine.divider.dto.*;
import com.b9ine.divider.model.*;
import org.modelmapper.ModelMapper;

public class MapperUtil {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BookerDTO convertToDTO(Booker booker) {
        return modelMapper.map(booker, BookerDTO.class);
    }

    public static Booker convertToEntity(BookerDTO bookerDTO) {
        return modelMapper.map(bookerDTO, Booker.class);
    }

    public static ClientDTO convertToDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public static Client convertToEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public static BookingDTO convertToDTO(Booking booking) {
        return modelMapper.map(booking, BookingDTO.class);
    }

    public static Booking convertToEntity(BookingDTO bookingDTO) {
        return modelMapper.map(bookingDTO, Booking.class);
    }

    public static RestaurantDTO convertToDTO(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    public static Restaurant convertToEntity(RestaurantDTO restaurantDTO) {
        return modelMapper.map(restaurantDTO, Restaurant.class);
    }

    public static CityDTO convertToDTO(City location) {
        return modelMapper.map(location, CityDTO.class);
    }

    public static City convertToEntity(CityDTO locationDTO) {
        return modelMapper.map(locationDTO, City.class);
    }

}
