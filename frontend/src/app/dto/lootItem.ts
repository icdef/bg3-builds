import { LootItemDetail } from './lootItemDetail';

export interface LootItem {
  itemName: string;
  itemEffect: string;
  itemSource: string;
  itemLocation: string;
  act: number;
  lootItemDetail: LootItemDetail;
}

export interface LootItemToggle extends LootItem {
  isLooted: boolean;
}
