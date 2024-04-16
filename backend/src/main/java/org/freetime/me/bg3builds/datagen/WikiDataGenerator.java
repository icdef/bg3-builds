package org.freetime.me.bg3builds.datagen;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.text.StringEscapeUtils;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDetailDto;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDto;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryResponseDto;
import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.freetime.me.bg3builds.mapper.LootItemDetailMapper;
import org.freetime.me.bg3builds.persistence.LootItemDetailRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;


@Component
@Slf4j
@RequiredArgsConstructor
public class WikiDataGenerator {

    private final LootItemDetailRepository lootItemDetailRepository;
    private final LootItemDetailMapper lootItemDetailMapper;
    private final ObjectMapper objectMapper;

    public void addWeaponData() {
        String uri = "https://bg3.wiki/w/api.php?action=cargoquery&format=json&origin=*&limit=500&tables=weapons&fields=weapons.name%2C%20weapons.price%2C%20weapons.type%2C%20";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(uri)
                .get()
                .build(); // defaults to GET
        try (Response response = client.newCall(request).execute()) {
            List<CargoQueryObjectDetailDto> list = getCleanedUpResultFromAPIRequest(response);
            List<LootItemDetail> weaponDetailList = lootItemDetailMapper.cargoQueryObjectDetailDtoToEntity(list);

            for (int i = 0; i < weaponDetailList.size(); i++) {
                LootItemDetail weaponDetailNew = weaponDetailList.get(i);
                Optional<LootItemDetail> weaponDetailOldOptional = lootItemDetailRepository.findByName(weaponDetailNew.getName());
                if (weaponDetailOldOptional.isPresent()) {
                    weaponDetailList.set(i, lootItemDetailMapper.updateLootItemDetail(weaponDetailNew, weaponDetailOldOptional.get()));
                }
            }

            lootItemDetailRepository.saveAll(weaponDetailList);
        } catch (IOException | NullPointerException e) {
            log.error(e.getMessage());
        }

    }


    public void addEquipmentData() {
        String uri = "https://bg3.wiki/w/api.php?action=cargoquery&format=json&origin=*&errorformat=raw&limit=500&tables=equipment&fields=equipment.name%2C%20equipment.type&offset=2&utf8=1";
        String uri2 = "https://bg3.wiki/w/api.php?action=cargoquery&format=json&origin=*&errorformat=raw&limit=500&tables=equipment&fields=equipment.name%2C%20equipment.type&offset=502&utf8=1";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(uri)
                .get()
                .build(); // defaults to GET
        handleAPIRequestForEquipment(client, request);
        request = new Request.Builder()
                .url(uri2)
                .get()
                .build();
        handleAPIRequestForEquipment(client, request);
    }

    private void handleAPIRequestForEquipment(OkHttpClient client, Request request) {
        try (Response response = client.newCall(request).execute()) {
            List<CargoQueryObjectDetailDto> list = getCleanedUpResultFromAPIRequest(response);
            List<LootItemDetail> lootItemDetails = lootItemDetailMapper.cargoQueryObjectDetailDtoToEntity(list);

            for (int i = 0; i < lootItemDetails.size(); i++) {
                LootItemDetail lootItemDetailNew = lootItemDetails.get(i);
                Optional<LootItemDetail> equipmentDetailOldOptional = lootItemDetailRepository.findByName(lootItemDetailNew.getName());
                if (equipmentDetailOldOptional.isPresent()) {
                    lootItemDetails.set(i, lootItemDetailMapper.updateLootItemDetail(lootItemDetailNew, equipmentDetailOldOptional.get()));
                }
            }

            lootItemDetailRepository.saveAll(lootItemDetails);

        } catch (IOException | NullPointerException e) {
            log.error(e.getMessage());
        }
    }

    private List<CargoQueryObjectDetailDto> getCleanedUpResultFromAPIRequest(Response response) throws IOException {
        CargoQueryResponseDto cargoQueryResponseDto = objectMapper.readValue(response.body().byteStream(), CargoQueryResponseDto.class);
        List<CargoQueryObjectDetailDto> list = cargoQueryResponseDto.getCargoquery().stream().map(CargoQueryObjectDto::getTitle)
                .filter(distinctByKey(CargoQueryObjectDetailDto::getName)).toList();

        for (CargoQueryObjectDetailDto cargoQueryObjectDetailDto : list) {
            cargoQueryObjectDetailDto.setName(decodeHtmlEntity(cargoQueryObjectDetailDto.getName()));
        }
        return list;
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private String decodeHtmlEntity(String htmlEntity) {
        return StringEscapeUtils.unescapeHtml4(htmlEntity);
    }
}
