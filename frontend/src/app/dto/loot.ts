export interface Loot {
  itemName: string;
  itemEffect: string;
  itemSource: string;
  itemLocation: string;
  act: number;
  lootItemDetail: LootItemDetail;
}

export interface LootTable {
  data: Loot[],
  total: number;
}

export interface LootItemDetail {
  type: string
  subtype: string
}